# AndroidMultiThread

### HandlerThread  
使用handler来进行UIThread 和 子线程直接通信
相对于直接用handler，HandlerThread简化了使用过程，把Looper.prepare(), Looper.loop()等过程包含在内，不需要用户每次重复写此几行代码
