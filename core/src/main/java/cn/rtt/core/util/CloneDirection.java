package cn.rtt.core.util;

/**
 * 克隆方向枚举
 */
public enum CloneDirection {

    /**
     * 正向克隆：从VO->DTO，DTO->DO
     */
    FORWARD(1),
    /**
     * 反向克隆：从DO->DTO，DTO->VO
     */
    OPPOSITE(2);

    private final Integer code;

    CloneDirection(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

}