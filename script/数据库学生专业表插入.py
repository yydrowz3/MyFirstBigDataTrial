# -*- coding: utf-8 -*-
"""
Created on Fri May 20 20:16:37 2022

@author: ASUSA
"""
import json
import pymysql

file_path = r'G:\知识\工程实践1\工程实践3\data\school_major'


conn = pymysql.connect(host="124.70.90.79",port=3306,user="root",passwd="123456",db="bigData" )
#获取一个游标对象
cursor=conn.cursor()
#执行数据库插入操作
id = 1
for i in open(file_path):
    
    s = i.split(' ')
    c = 'insert into school_major(id,school_code,major_code) values ({},"{}","{}")'.format(id,s[0],s[1])
    print(c)
    cursor.execute(c)
    id += 1
#提交
conn.commit()
#关闭连接
conn.close()
cursor.close()
