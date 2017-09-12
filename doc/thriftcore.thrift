namespace java products.thrift
#include "entity.thrift"
#include "../../imp_message_core/doc/impMsg.thrift"
#include "../../imp_message_core/doc/impMsgService.thrift"

	#布尔型返回值
struct BooleanResult{
	1:optional bool result;	#返回结果
	2:optional i32 err_code;	#异常编码
	3:optional string err_msg;	#异常消息
}

service ThriftService {	
	
	# 检查server是否正常
	BooleanResult serverState(1:string userid)
}

