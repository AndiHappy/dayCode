namespace java products.thrift
#include "entity.thrift"
#include "../../imp_message_core/doc/impMsg.thrift"
#include "../../imp_message_core/doc/impMsgService.thrift"

	#ͷֵ
struct BooleanResult{
	1:optional bool result;	#ؽ
	2:optional i32 err_code;	#쳣
	3:optional string err_msg;	#쳣Ϣ
}

service ThriftService {	
	
	# serverǷ
	BooleanResult serverState(1:string userid)
}

