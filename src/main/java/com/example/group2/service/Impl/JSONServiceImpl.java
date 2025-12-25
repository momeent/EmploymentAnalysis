package com.example.group2.service.Impl;
import com.alibaba.fastjson.JSONObject;
import com.example.group2.entity.User;
import com.example.group2.service.JSONService;
import com.example.group2.util.Education;
import com.example.group2.util.Experience;
import com.example.group2.util.Project;
import com.example.group2.util.Resume;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import java.io.*;
import java.io.InputStream;

@Service
public class JSONServiceImpl implements JSONService {


    private static String SPACE = "   ";
    @Override
    public JSONObject createJson(User user) {
        String rootPath = System.getProperty("user.dir");   //根路径
        String path = rootPath+"\\src\\main\\resources\\Users\\" + user.getUserId() + "\\resume" + user.getUserId() + ".json";
        //为唯一的用户电话号码新建一个简历文件
        System.out.println("path:" +path);
        try{
            //保证创建一个新文件
            File file = new File(path);
            if(!file.getParentFile().exists()){
                //如果父目录不存在，创建父目录
                file.getParentFile().mkdir();
            }
            if(file.exists()){
                //已存在，删除旧文件
                file.delete();
            }
            file.createNewFile();

            //创建json格式内容
            //创建一个json对象
            JSONObject root = new JSONObject();
            root.put("name", "");
            root.put("birthday_date", "");
            root.put("gender", "");
            root.put("graduation_year", "");
            root.put("city", "");
            root.put("identity", "");
            root.put("tel", "");
            root.put("email", "");

            JSONObject expectation = new JSONObject();
            expectation.put("expected_industry", "");
            expectation.put("expected_position", "");
            expectation.put("position_details", "");
            expectation.put("salary_requirements", "");
            expectation.put("work_city", "");
            expectation.put("other_city", "");
            root.put("expectation", expectation);

            root.put("personal_advantages", "");

            Experience[] experience = new Experience[1];
            experience[0] = new Experience();
            experience[0].setWork_time("");
            experience[0].setCompany_name("");
            experience[0].setPosition_name("");
            experience[0].setIndustry("");
            experience[0].setJob_description("");
            experience[0].setIsInternship("");
            root.put("experiences", experience);

            Project[] projects = new Project[1];
            projects[0] = new Project();
            projects[0].setProject_time("");
            projects[0].setProject_name("");
            projects[0].setRole("");
            projects[0].setProject_description("");
            projects[0].setProject_performance("");
            projects[0].setProject_link("");
            root.put("projects", projects);

            Education[] educations = new Education[1];
            educations[0] = new Education();
            educations[0].setStudy_time("");
            educations[0].setUniversity("");
            educations[0].setMajor("");
            educations[0].setQualification("");
            educations[0].setMajor_cources("");
            educations[0].setProfession_rank("");
            educations[0].setStudy_experience("");
            root.put("educations", educations);

            String[] honor = new String[1];
            honor[0] = "";
            root.put("honor", honor);

            String[] certificate = new String[1];
            certificate[0] = "";
            root.put("certificate", certificate);
            root.put("organization", "");
            root.put("major_skills", "");

            //格式化字符串
            String jsonString = formatJson(root.toString());

            //将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
            return root;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回格式化JSON字符串。
     *
     * @param json 未格式化的JSON字符串。
     * @return 格式化的JSON字符串。
     */
    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;

        // 遍历输入字符串。
        for (int i = 0; i < length; i++) {
            // 1、获取当前字符。
            key = json.charAt(i);

            // 2、如果当前字符是前方括号、前花括号做如下处理：
            if ((key == '[') || (key == '{')) {
                // （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }

                // （2）打印：当前字符。
                result.append(key);

                // （3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                // （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                // （5）进行下一次循环。
                continue;
            }

            // 3、如果当前字符是后方括号、后花括号做如下处理：
            if ((key == ']') || (key == '}')) {
                // （1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                // （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                // （3）打印：当前字符。
                result.append(key);

                // （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }

                // （5）继续下一次循环。
                continue;
            }

            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if ((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            // 5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }


    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }

    public JSONObject fileToJson(String fileName) {
//        JSONObject json = null;
//        try (
//                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
//        ) {
//            json = JSONObject.parseObject(IOUtils.toString(is, "utf-8"));
//        } catch (Exception e) {
//            System.out.println(fileName + "文件读取异常" + e);
//        }
//        return json;
        // 指定JSON文件路径
        String jsonFilePath = fileName;

        // 创建ObjectMapper对象，它是Jackson库中用于读取和写入JSON的主要类
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 从JSON文件中读取数据并映射到指定的Java对象类型
            JSONObject jsonObject = objectMapper.readValue(new File(jsonFilePath), JSONObject.class);
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新简历
//     * @param resume 简历对象
     * @param userId 用户id
     */
    @Override
    public void updateResume(JSONObject jsonObject, int userId) {
        //得到用户json文件的路径
        String rootPath = System.getProperty("user.dir");   //根路径
        String path = rootPath+"\\src\\main\\resources\\Users\\" + userId + "\\resume" + userId + ".json";
        writeJsonToFile(jsonObject, path);

    }

    /**
     * gpt写的将json对象转文件
     * @param jsonObject
     * @param filePath
     */
    public void writeJsonToFile(JSONObject jsonObject, String filePath) {
        try {
            // 创建 ObjectMapper 对象
            ObjectMapper objectMapper = new ObjectMapper();

            // 将 JSON 对象转换为 JSON 字符串
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            String jsonContent = objectWriter.writeValueAsString(jsonObject);

            // 将 JSON 字符串写入文件
            File jsonFile = new File(filePath);
            objectMapper.writeValue(jsonFile, jsonObject);

            System.out.println("写入 JSON 文件成功：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("写入 JSON 文件失败: " + e.getMessage());
        }
    }

}
