package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV1Test {

    @Autowired
    CallServiceV1 callServiceV1; // 스프링 컨테이너에 프록시로 올라간다.

    @Test
    void external() {
        callServiceV1.external();
    }

    @Test
    void internal() {
        callServiceV1.internal();
    }
}