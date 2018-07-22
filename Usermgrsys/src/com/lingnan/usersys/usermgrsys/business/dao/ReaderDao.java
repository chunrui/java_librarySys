package com.lingnan.usersys.usermgrsys.business.dao;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgrsys.domian.ReaderVO;
/**
 * 读者dao接口
 * @author Administrator
 *
 */
public interface ReaderDao extends BaseDao{
	/**
	 *添加读者
	 * @param reader 读者信息
	 * @return 返回值为true或者false
	 */
	public boolean addReader(ReaderVO reader);
	/**
	 * 读者信息更新
	 * @param reader 读者信息
	 * @return 返回true或者false
	 */
	public boolean updateReader(ReaderVO reader);
	/**
	 * 根据id查找读者
	 * @param rid 读者编号
	 * @return  返回读者对象
	 */
	public ReaderVO findReaderByid(String rid);
	
	/**
	 * 查找所有读者
	 * @return  返回读者对象	 
	 */
	public Vector<ReaderVO> findAllReader();
	/**
	 * 根据rid号删除读者
	 * @param rid 读者编号
	 * @return  true或者false
	 */
	public boolean deleteReaderByid(String rid);
}
