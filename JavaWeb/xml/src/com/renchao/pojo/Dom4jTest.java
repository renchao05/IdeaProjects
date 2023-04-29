package com.renchao.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {

    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            System.out.println(new Book(book.attributeValue("sn"), book.elementText("name"),
                    new BigDecimal(book.elementText("price")), book.elementText("author")));
        }
    }
    
    @Test
    public void testDom4j() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element root = document.getRootElement();
        List<Element> books = root.elements();
        for (Element book : books) {
            String name = book.element("name").getText();
            String price = book.element("price").getText();
            String author = book.element("author").getText();
            String sn = book.attributeValue("sn");
            Book b = new Book(sn, name, new BigDecimal(price), author);
            System.out.println(b);
        }
    }
}
