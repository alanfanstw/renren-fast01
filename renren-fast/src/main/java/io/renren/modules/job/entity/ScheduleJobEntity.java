package io.renren.modules.job.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 定时器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月28日 下午12:54:44
 */
@ApiModel(value="定时器")
public class ScheduleJobEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务调度参数key
	 */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";
	
	/**
	 * 任务id
	 */
    @ApiModelProperty(value="任务id",required=true,example="")
	private Long jobId;

	/**
	 * spring bean名称
	 */
	@NotBlank(message="bean名称不能为空")
	@ApiModelProperty(value="spring bean名称",required=true,example="")
	private String beanName;
	
	/**
	 * 方法名
	 */
	@NotBlank(message="方法名称不能为空")
	@ApiModelProperty(value="方法名",required=true,example="")
	private String methodName;
	
	/**
	 * 参数
	 */
	@ApiModelProperty(value="参数",required=true,example="")
	private String params;
	
	/**
	 * cron表达式
	 */
	@NotBlank(message="cron表达式不能为空")
	@ApiModelProperty(value="cron表达式",required=true,example="")
	private String cronExpression;

	/**
	 * 任务状态  0：正常  1：暂停
	 */
	@ApiModelProperty(value="任务状态  0：正常  1：暂停",required=true,example="")
	private Integer status;

	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注",required=true,example="")
	private String remark;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间",required=true,example="")
	private Date createTime;

	/**
	 * 设置：任务id
	 * @param jobId 任务id
	 */
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	/**
	 * 获取：任务id
	 * @return Long
	 */
	public Long getJobId() {
		return jobId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 设置：任务状态
	 * @param status 任务状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：任务状态
	 * @return String
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置：cron表达式
	 * @param cronExpression cron表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * 获取：cron表达式
	 * @return String
	 */
	public String getCronExpression() {
		return cronExpression;
	}
	
	/**
	 * 设置：创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
