package com.example.functionwithretry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiCaller {
    private static final int MAX_RETRIES = 3;

    public int callApi() {
        // Ваш код для вызова API
        // Здесь предполагается, что вызов API возвращает статус
        // 502 - ошибка, требующая повторного вызова
        // Другие статусы могут быть обработаны по-другому в зависимости от требований
        return 502;
    }

    public int callApiWithRetry(int retryCount) {
        int status = callApi();
        if (retryCount < 1) {
            return status;
        }
        if (status == 502) {
            return callApiWithRetry(retryCount - 1);
        } else {
            return status;
        }
    }

    @Test
    public void testCallApiWithRetry_Successful() {
        ApiCaller apiCaller = new ApiCaller();

        int result = apiCaller.callApiWithRetry(MAX_RETRIES);

        // Проверяем, что результат вызова равен ожидаемому успешному статусу
        assertEquals(200, result);
    }

    @Test
    public void testCallApiWithRetry_RetriesExhausted() {
        ApiCaller apiCaller = new ApiCaller();

        int result = apiCaller.callApiWithRetry(0);

        // Проверяем, что результат вызова равен статусу ошибки, так как попытки исчерпаны
        assertEquals(502, result);
    }
}
