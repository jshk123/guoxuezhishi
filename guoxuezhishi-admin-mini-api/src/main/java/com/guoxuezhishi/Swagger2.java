package com.guoxuezhishi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        // 为swagger添加header参数可供输入
        ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        userTokenHeader.name("headerUserToken").description("userToken")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        userIdHeader.name("headerUserId").description("userId")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.wechat"))
                .paths(PathSelectors.any()).build()
                .groupName("国学知识")
                .globalOperationParameters(pars);
    }

    @Bean
    public Docket createRestApiH5ChePaiFu() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.h5chepaifu"))
                .paths(PathSelectors.any()).build()
                .groupName("H5车牌付");
    }

    @Bean
    public Docket createRestApiLstChePaiFu() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.lstchepaifu"))
                .paths(PathSelectors.any()).build()
                .groupName("乐速通车牌付");
    }

    @Bean
    public Docket createRestApiChePaiFu() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.yunzhongxin"))
                .paths(PathSelectors.any()).build()
                .groupName("云中心相关");
    }

    @Bean
    public Docket createRestApiEAccount() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.eaccount"))
                .paths(PathSelectors.any()).build()
                .groupName("小程序工行二类户");
    }

    @Bean
    public Docket createRestApiBjfhApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.bjfhapi"))
                .paths(PathSelectors.any()).build()
                .groupName("北京分行二类户");
    }

    @Bean
    public Docket createRestApiWXFenZhang() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.wxfenzhang"))
                .paths(PathSelectors.any()).build()
                .groupName("微信分账");
    }


    @Bean
    public Docket createRestApiBDApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.baiduapi"))
                .paths(PathSelectors.any()).build()
                .groupName("百度业务");
    }

    @Bean
    public Docket createRestApiJiaoHangYun() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.jiaohangyun"))
                .paths(PathSelectors.any()).build()
                .groupName("交行云账户");
    }

    @Bean
    public Docket createRestApiGaoSu() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.gaosuapi"))
                .paths(PathSelectors.any()).build()
                .groupName("高速收费");
    }

    @Bean
    public Docket createRestApiJssh() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxuezhishi.controller.ssh"))
                .paths(PathSelectors.any()).build()
                .groupName("Linux控制台");
    }

    /**
     * @Description: 构建 api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("JIANG的接口测试")
                // 设置联系人
                .contact(new Contact("JIANG", "http://www.jiangshikai.com", "jshk123@163.com"))
                // 描述
                .description("JIANG的接口测试")
                // 定义版本号
                .version("1.0").build();
    }

}
