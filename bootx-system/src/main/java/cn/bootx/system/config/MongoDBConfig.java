package cn.bootx.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * mongoDB配置类
 * @author xxm
 * @date 2018/12/19 17:34
 * @version V1.0
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com"})
public class MongoDBConfig  {

//    @Override
//    public MongoClient mongoClient() {
//        return new MongoClient();
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "oss";
//    }
//
//    /**
//     * 扫描包路径
//     * @return Collection
//     */
//    @Override
//    protected Collection<String> getMappingBasePackages() {
//        return Collections.singletonList( "com" );
//    }

}
