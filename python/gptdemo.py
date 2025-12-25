#!/usr/bin/env python
# -*- coding: UTF-8 -*-
'''
@Project ：douban 
@File    ：gptdemo.py
@IDE     ：PyCharm 
@Author  ：hjh
@Date    ：2024/1/8 22:06 
'''

import erniebot
import sys
import json


def communicate(str):

# 文心一言api的个人key
    erniebot.api_type = '*****'
    erniebot.access_token = '*******'

    response = erniebot.ChatCompletion.create(
        model='ernie-bot',
        messages=[{'role': 'user', 'content': str}],
    )
    print(response.get_result())
    sys.exit(0)






if __name__ == "__main__":
    #从命令行获取两个参数  一个是文字，一个是文件路径
    quesion = sys.argv[1]
    path = sys.argv[2]

    #读取简历
    with open(path, encoding='utf-8') as file:
        # 使用json.load()方法加载JSON数据
        data = json.load(file)

    # 将JSON数据转换为字符串
    json_string = json.dumps(data)
    communicate(quesion+json_string)