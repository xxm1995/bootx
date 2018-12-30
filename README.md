# cb-web

跨境协会前端展示(用户用)


<pre>
├─cashRecord            后台页面
├─courseBuyRecord       前台页面 个人购课记录 已弃用
├─courseCatalog         后台页面 课程目录管理
├─courseOnline          后台页面 线上课程管理
├─exam                  后台页面 考试管理
├─examRegistration      后台页面 考试报名详情
├─home                                                 前台页面
│  ├─buy                                               前台页面 个人中心页面 购买页面 
│  ├─edge                                              网页头部尾部 登录注册页面
│  ├─index                                             前台页面 主页面（轮播图）
│  ├─list                                              前台页面 全部课程展示 单个课程信息展示
│  └─search                                            前台页面 查询结果
├─lecturer              后台页面 教师管理
└─trainee               后台页面 学员管理
</pre>
# 后台模块划分
<pre>
├─apply 移动端
│  ├─exam
│  │  ├─detail 考试列表
│  │  ├─registration 考试报名
│  └─wxpay 微信支付
├─balance 余额管理
├─cashrecord 现金交易记录
├─course
│  ├─catalog 课程目录
│  ├─online 线上课程管理
│  └─record 课程购买记录
├─home
│  ├─detail 课程管理
│  │  ├─controller 课程信息展示
│  │  ├─directory 弃用
│  │  └─entity 课程目录实体
│  ├─index 前台页面展示(主页)
│  ├─list 前台页面展示（所有课程展示）
│  ├─search 主页展示 详情页面
│  ├─self 支付页面
├─member
│  ├─lecturer 讲师管理
│  └─trainee 学院管理
├─moneycenter
│  └─service 统一支付接口
├─ordercenter 订单中心
└─oss 文件上传
</pre>