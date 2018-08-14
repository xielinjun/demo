package com.xlj.beanwiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Configs.CDConfig.class, Configs.PlayerConfig.class})
public class Configs {


    @Configuration
    public static class CDConfig
    {
        @Bean("sgtPeppersCompactDiscImpl")
        public CompactDisc getSgtPeppersCompactDiscImpl()
        {
            return new SgtPeppersCompactDiscImpl();
        }
    }

    @Configuration
    @Import(CDConfig.class)
    public static class PlayerConfig
    {
        @Bean("cdPlayer")
        public MediaPlayer getCDPlayer(CompactDisc cd)
        {
            return new CDPlayer(cd);
        }

    }
}
