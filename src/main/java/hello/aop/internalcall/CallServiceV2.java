package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {
    private final ObjectProvider<CallServiceV2> callServiceProvider; // 지연 조회 방식(스프링 빈 생성 시점 -> 실제 객체를 사용하는 시점으로 지연 조회)


    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceProvider) {
        this.callServiceProvider = callServiceProvider;
    }

    public void external() {
        log.info("call external");
        CallServiceV2 callServiceV2 = callServiceProvider.getObject(CallServiceV2.class);
        callServiceV2.internal(); // 내부 메서드 호출(this.internal())
    }

    public void internal() {
        log.info("call internal");
    }
}
