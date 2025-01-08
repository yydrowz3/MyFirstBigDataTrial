# pip install pymysql
# 修改文件路径 file
# 修改数据库信息
# 修改sql语句
# 修改temp

import os
import pymysql

data = ()
dataset = []
file = ""

# 打开数据库连接
db = pymysql.connect(host='xx.xx.xx.xx', port=3306,
                     user='root', passwd='123456',
                     db='bigData', charset='utf8')


# SQL 插入语句
sql = "INSERT INTO `enrollment_info` (" \
      "`school_code`, `school_name`, " \
      "`province`, `major_code`,`" \
      "profess`,`subject`," \
      "`batch`,`plan`) " \
      "VALUES (%s,%s,%s,%s,%s,%s,%s,%s)"


try:
    with db.cursor() as cursor:
        params = []
        sum = 0
        with open(file, "r", encoding='utf-8') as f:
            lines = f.readlines()
            for line in lines:
                temp = line.split("\t")

                #判断一下更安全
                if len(temp) == 8:
                    sum = sum + 1
                    params.append((temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]))
                if len(params) == 1000:
                    cursor.executemany(sql, params)
                    params.clear()
                f.close()


        if len(params) > 0:
            cursor.executemany(sql, params)
        # 提交到数据库执行
        print(sum)
        db.commit()

except pymysql.MySQLError as err:
    # 如果发生错误则回滚
    db.rollback()
    print(type(err), err)

# 关闭游标
cursor.close()
# 关闭数据库连接
db.close()








