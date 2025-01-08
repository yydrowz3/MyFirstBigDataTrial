# -*- coding: utf-8 -*-
"""
Created on Wed May 25 21:17:35 2022

@author: ASUSA
"""

import json
import pymysql

file_path = r'G:\知识\工程实践1\工程实践3\data\TopMin\part-r-00000'


conn = pymysql.connect(host="124.70.90.79",port=3306,user="root",passwd="123456",db="bigData" )
#获取一个游标对象
cursor=conn.cursor()
#执行数据库插入操作
id = 1
for i in open(file_path,encoding='utf-8'):
    
    s = i.split('\t')
    c = 'insert into mintop(id,major_code,plan) values ({},"{}",{})'.format(id,s[0],s[1])
    #print(c)
    cursor.execute(c)
    id += 1
#提交
conn.commit()
#关闭连接
conn.close()
cursor.close()