/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.examples.jackson;

import com.alibaba.dubbo.examples.jackson.api.JacksonBean;
import com.alibaba.dubbo.examples.jackson.api.JacksonInnerBean;
import com.alibaba.dubbo.examples.jackson.api.JacksonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JacksonConsumer
 *
 * @author dylan
 */
public class JacksonConsumer {

    public static void main(String[] args) throws Exception {
        String config = JacksonConsumer.class.getPackage().getName().replace('.', '/') + "/jackson-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        JacksonService jacksonService = (JacksonService) context.getBean("jacksonService");
        String hello = jacksonService.sayHello("world");
        System.out.println(hello);

        JacksonBean jacksonBean = jacksonService.testJacksonBean(new JacksonBean(), new JacksonInnerBean());
        System.out.println(jacksonBean);
        System.in.read();
    }

}
