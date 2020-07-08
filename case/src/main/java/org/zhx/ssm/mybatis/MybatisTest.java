package org.zhx.ssm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.zhx.ssm.mybatis.example.Nation;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {


    public static void buildSession() {
//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public static void main(String args[]) {
        InputStream inputStream = null;
        try {
            String resource = "org/zhx/ssm/mybatis/mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            Nation nation = (Nation) session.selectOne("org.zhx.ssm.mybatis.example.selectNation", 20);
            System.out.println(nation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
