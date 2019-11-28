package com.luge.dao;

import com.luge.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    /**
     * 根据名称查询
     */
    @Query("from Customer where custName = ?")
    public Customer findByName(String custName);

    /**
     * 根据名称和id查询
     */
    @Query("from Customer where custName = ?2 and custId = ?1")
    public Customer findByNameAndId(Long custId, String custName);


    /**
     * jpql根据id更新客户信息操作
     */
    @Query("update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(Long id, String name);


    /**
     * sql语句查询所有
     */
    @Query(value = "select * from cst_customer", nativeQuery = true)
    public List<Object[]> findBySql();

    /**
     * sql根据名称进行模糊查询
     */
    @Query(value = "select * from cst_customer where cust_name like ?", nativeQuery = true)
    public List<Object[]> findBySql2(String name);

    /**
     * 方法名称规则查询
     */
    public Customer findByCustName(String name);

    public List<Customer> findByCustNameLike(String name);

    public List<Customer> findByCustNameLikeAndCustLevel(String name, String level);
}
