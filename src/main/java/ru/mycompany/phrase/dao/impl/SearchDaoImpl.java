package ru.mycompany.phrase.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@Repository
@Transactional
public class SearchDaoImpl extends JdbcDaoSupport implements SearchDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }




}


