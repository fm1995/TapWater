package com.sy.service.py;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service �ĸ���ӿ� ����ʵ�ָýӿ� 
 * ʵ�ָýӿ�,��Ҫ�� T ��Ϊ��Ҫ�Ĳ�������
 * @author BarryLiu
 * @param <T> ����ĸ� entity ��Service 
 */
@Service
public interface ParentSerI<T>{

	/**
	 * ��ѯȫ��
	 * @return
	 */
	List<T> getAll();
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(String id);

	/**
	 * ����һ����¼
	 * @param entity
	 * @return
	 */
	int insert(T entity);

	/**
	 * �޸�
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * ����idɾ��
	 * @param id
	 * @return
	 */
	int delete(String id);
}