package algorithm;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class Main {
    private static long  workerId ;//为终端ID
    private static  long datacenterId = 1;//数据中心ID
    private static Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(snowflake.nextId());
        }
    }
}
