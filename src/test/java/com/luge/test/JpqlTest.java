package com.luge.test;

import com.luge.dao.CustomerDao;
import com.luge.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据名称查询
     */
    @Test
    public void test1() {
        Customer customer = customerDao.findByName("阿里巴巴");
        System.out.println(customer);
    }

    /**
     * 根据id和名称查询
     */
    @Test
    public void test2() {
        Customer customer = customerDao.findByNameAndId(2l, "阿里巴巴");
        System.out.println(customer);
    }

    /**
     * 使用sql语句查询所有
     */
    @Test
    public void test3() {
        List<Object[]> list = customerDao.findBySql();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    /**
     * jpql根据id更新客户信息操作
     */
    @Test
    @Transactional // 开启事务支持
    @Rollback(value = false) // 设置为手动回滚
    public void test4() {
        customerDao.updateCustomer(10l, "滴滴2");
    }

    /**
     * sql根据名称进行模糊查询
     */
    @Test
    public void test5() {
        List<Object[]> list = customerDao.findBySql2("滴滴%");
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    /**
     * 测试方法名规则查询
     */
    @Test
    public void test6() {
        Customer customer = customerDao.findByCustName("滴滴");
        System.out.println(customer);
    }

    @Test
    public void test7() {
        List<Customer> list = customerDao.findByCustNameLike("滴滴%");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void tset8() {
        List<Customer> list = customerDao.findByCustNameLikeAndCustLevel("腾讯%", "中级");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
