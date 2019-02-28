# springCloudDemo

首先启动服务端，然后启动4个客户端  
可以在本地 8761 端口查看服务依次注册  
然后在 8762端口测试api /test 可以查看接口被调用  
然后在 8093端口测试api /test 发现依次通过ribbon两个服务器调用client 接口 ，实现负载均衡
