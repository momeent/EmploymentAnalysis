#!\\usr\\bin\\env python
# -*- coding: UTF-8 -*-
'''
@Project ：douban 
@File    ：getResumepdf.py
@IDE     ：PyCharm 
@Author  ：hjh
@Date    ：2024\\1\\11 16:29 
'''

from docxtpl import DocxTemplate
import aspose.words as aw
import argparse
import json
import os
import sys

# 根路径 XJTU
rootPath = os.path.abspath('.')



def fill_template(template_path, user_data, userId):
    # 读取模板文档
    tpl = DocxTemplate(template_path)

    # 替换文档中的占位符
    tpl.render(user_data)

    # 另存为新的 Word 文档
    output_path = rootPath + '\\src\\main\\resources\\Users\\' + userId + '\\resume.docx'
    tpl.save(output_path)

    return output_path


def main(userId):

    json_path = rootPath+'\\src\\main\\resources\\Users\\' + userId + '\\resume' + userId + '.json'
    pdf_path = rootPath+'\\src\\main\\resources\\Users\\' + userId + '\\resume.pdf'

    print(json_path)
    print(pdf_path)
    # 从JSON文件中加载用户数据
    with open(json_path, 'r', encoding='utf-8') as json_file:
        user_data = json.load(json_file)

    print(json_path)
    print(pdf_path)

    # 设置模板路径
    template_path = rootPath + "\\python\\model2.docx"
    # 填充模板
    filled_resume = fill_template(template_path, user_data, userId)

    # 使用Aspose.Words将Word文档转换为PDF
    doc = aw.Document(filled_resume)
    doc.save(pdf_path)



# 读取 .docx 模板
# template_path = "E:\\python\\pythonProject\\model2.docx"
#
# user_data = {
#     "name": "张三",
#     "gender": "男",
#     "identity": "学生",
#     "graduation_year": "2022",
#     "tel": "123456789",
#     "birthday_date": "2000-01-01",
#     "city": "某地",
#     "email": "zhangsan@example.com",
#     "job_status": "在校-考虑机会",
#     "personal_advantages": "沟通能力强，团队协作",
#     "expected_industry": "IT",
#     "expected_position": "软件工程师",
#     "position_details": "Web开发",
#     "salary_requirements": "15000元\\月",
#     "work_city": "北京",
#     "other_city": "上海",
#     "experiences": [
#         {
#             "company_name": "ABC公司",
#             "industry": "IT",
#             "work_time": "2020 - 2022",
#             "position_name": "实习生",
#             "job_description": "负责前端开发",
#             "isInternship": "是",
#         },
#     ],
#     "projects": [
#         {
#             "project_name": "项目A",
#             "role": "项目经理",
#             "project_time": "2021 - 2022",
#             "project_description": "开发一个Web应用",
#             "project_performance": "成功上线",
#             "project_link": "http:\\\\projecta.com",
#         },
#         {
#             "project_name": "项目B",
#             "role": "开发工程师",
#             "project_time": "2022 - 2023",
#             "project_description": "设计和实施数据库系统",
#             "project_performance": "提高系统性能",
#             "project_link": "http:\\\\projectb.com",
#         },
#     ],
#     "educations":[
#         {
#             "university": "某大学",
#             "qualification": "本科",
#             "major": "计算机科学与技术",
#             "study_time": "时间段：2018-2022",
#             "major_courses": "数据结构，算法",
#             "profession_rank": "前30%",
#             "study_experience": "参与学生科研项目",
#         },
#     ],
#     "honor_name": "优秀学生奖",
#     "certificate_name": "计算机专业证书",
#     "organization_name": "学生会",
#     "organization_role": "主席",
#     "organization_time": "时间段：2019-2021",
#     "experience_description": "经历描述：组织校园活动",
#     "major_skills": "Python, HTML, CSS, JavaScript",
# }
#
# # 填充模板
# filled_resume = fill_template(template_path, user_data)
#
# doc = aw.Document("word_resume.docx")
# doc.save("pdf_resume.pdf")

if __name__ == '__main__':
    userId = sys.argv[1]
    main(userId)
    print("is in python")
    # print(os.getcwd())  # F:\hjh\XJTU\python
    # print(os.path.abspath('.'))