package com.study.jpa.sora;

import com.study.jpa.sora.domain.entity.Team;
import com.study.jpa.sora.domain.entity.User;
import com.study.jpa.sora.domain.repository.TeamRepository;
import com.study.jpa.sora.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@AllArgsConstructor
public class SoraApplication {
    UserRepository userRepository;
    TeamRepository teamRepository;

    public static void main(String[] args) {

        SpringApplication.run(SoraApplication.class, args);
    }

    @Bean
    InitializingBean init() {
        return () -> {
            for(int i=1; i<=5; i++){
                Team team = new Team();
                team.setName("팀"+i);
                team.setScore(20*i);
                teamRepository.save(team);

                for(int j=1; j<=200; j++) {
                    String name;
                    String Grade;
                    int mod = j%5;
                    int idx = (j+4)/5;
                    switch (mod){
                        case 1 :
                            name = "둘리";
                            Grade = "A";
                            break;
                        case 2 :
                            name = "도우너";
                            Grade = "B";
                            break;
                        case 3 :
                            name = "마이콜";
                            Grade = "C";
                            break;
                        case 4 :
                            name = "희동";
                            Grade = "D";
                            break;
                        default:
                            name = "고길동";
                            Grade = "X";
                            break;
                    }
                    User user = new User();
                    user.setName(name + idx);
                    user.setAge(idx);
                    user.setGrade(Grade);
                    user.setTeam(team);
                    userRepository.save(user);
                }
            }
        };

    }
}
