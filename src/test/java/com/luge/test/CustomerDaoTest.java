package com.luge.test;

import com.luge.dao.CustomerDao;
import com.luge.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 声明spring提供的测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml") // 指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(11l);
        System.out.println(customer);
    }

    /**
     * 保存
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("滴滴");
        customer.setCustIndustry("互联网");
        customer.setCustAddress("浙江杭州");
        customerDao.save(customer);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        customerDao.delete(11l);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
