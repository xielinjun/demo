package com.xlj.beanwiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDAndPlayerConfig {

    @Bean(name = "sgtPeppers")
    public CompactDisc getSgtPeppers()
    {
        return new SgtPeppersCompactDiscImpl();
    }

    @Bean("cdPlayer")
    public MediaPlayer getCDPlayer()
    {
        return new CDPlayer(getSgtPeppers());
    }

//    @Bean("cdPlayer2")
//    public MediaPlayer getCDPlayer2()
//    {
//        return new CDPlayer(getSgtPeppers());
//    }
//
//    @Bean("cdPlayer3")
//    public MediaPlayer getCDPlayer3(CompactDisc cd)
//    {
//        return new CDPlayer(cd);
//    }

}
