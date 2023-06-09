package com.renchao.fund.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.id
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.pid
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.name
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.url
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.icon
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    private String icon;

    private Boolean open = true;

    private final List<Menu> children = new ArrayList<>();

    public void addChild(Menu menu) {
        children.add(menu);
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<Menu> getChildren() {
        return children;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.id
     *
     * @return the value of t_menu.id
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.id
     *
     * @param id the value for t_menu.id
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.pid
     *
     * @return the value of t_menu.pid
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.pid
     *
     * @param pid the value for t_menu.pid
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.name
     *
     * @return the value of t_menu.name
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.name
     *
     * @param name the value for t_menu.name
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.url
     *
     * @return the value of t_menu.url
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.url
     *
     * @param url the value for t_menu.url
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.icon
     *
     * @return the value of t_menu.icon
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.icon
     *
     * @param icon the value for t_menu.icon
     *
     * @mbggenerated Wed May 18 14:00:45 CST 2022
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}