package com.ddoong2.whyusewebflux.lazyservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LazyServiceApplicationTests {

    @Test
    @DisplayName("환경을 로드한다")
    void 환경을_로드한다() {

        // Given - 사전 조건 설정
        // When - 검증하려는 로직 실행
        // Then - 출력 확인
    }


    @Test
    @DisplayName("최대값 최소값 체크")
    void 최대값_최소값_체크() {

        // Given - 사전 조건 설정

        // When - 검증하려는 로직 실행
        final int result = (int) (Math.random() * 1000 + 1000);

        // Then - 출력 확인
        assertThat(result).isGreaterThanOrEqualTo(1000).isLessThanOrEqualTo(2000);
    }

}
