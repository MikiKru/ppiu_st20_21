package pl.utp.ppiu.repository;

import org.springframework.stereotype.Component;
import pl.utp.ppiu.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public interface UserRepository {
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("mk@mk.pl", "mk", true, LocalDateTime.of(2010, 5, 3, 10, 10)),
            new User("aa@aa.pl", "aa", true, LocalDateTime.of(2012, 2, 21, 10, 10)),
            new User("qq@qq.pl", "qq", true, LocalDateTime.of(2014, 6, 20, 10, 10)),
            new User("tt@tt.pl", "tt", true, LocalDateTime.of(2016, 10, 3, 10, 10)),
            new User("rr@rr.pl", "rr", true, LocalDateTime.of(2018, 11, 4, 10, 10))
    ));
}
