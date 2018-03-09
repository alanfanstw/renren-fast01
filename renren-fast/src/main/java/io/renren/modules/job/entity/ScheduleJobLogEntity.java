package io.renren.modules.job.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 定时执行日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月1日 下午10:26:18
 */
@ApiModel(value="定时执行日志")
public class ScheduleJobLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 日志id
	 */
	@ApiModelProperty(value="日志id",required=true,example="")
	private Long logId;
	
	/**
	 * 任务id
	 */
	@ApiModelProperty(value="任务id",required=true,example="")
	private Long jobId;
	
	/**
	 * spring bean名称
	 */
	@ApiModelProperty(value="spring bean名称",required=true,example="")
	private String beanName;
	
	/**
	 * 方法名
	 */
	@ApiModelProperty(value="方法名",required=true,example="")
	private String methodName;
	
	/**
	 * 参数
	 */
	@ApiModelProperty(value="参数",required=true,example="")
	private String params;
	
	/**
	 * 任务状态    0：成功    1：失败
	 */
	@ApiModelProperty(value="任务状态    0：成功    1：失败",required=true,example="")
	private Integer status;
	
	/**
	 * 失败信息
	 */
	@ApiModelProperty(value="失败信息",required=true,example="")
	private String error;
	
	/**
	 * 耗时(单位：毫秒)
	 */
	@ApiModelProperty(value="耗时(单位：毫秒)",required=true,example="")
	private Integer times;
	
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间",required=true,example="")
	private Date createTime;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
