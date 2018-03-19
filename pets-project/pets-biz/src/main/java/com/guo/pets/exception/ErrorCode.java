package com.guo.pets.exception;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    private final static Map<Integer, String> constants = new HashMap<Integer, String>();

    /**
     * 正常；请求已经完成
     */
    public static final int STATUS_200 = 200;

    /**
     * 正常;已接受用于处理，但处理尚未完成
     */
    public static final int STATUS_202 = 202;

    /**
     * 正常；返回的只是一部分信息
     */
    public static final int STATUS_203 = 203;

    /**
     * 正常；无响应-已接受请求，但不存在要回送的信息。
     */
    public static final int STATUS_204 = 204;

    /**
     * 错误的请求，请求的参数类型与服务方要求的不匹配
     */
    public static final int STATUS_400 = 400;

    /**
     * 请求的服务未经授权
     */
    public static final int STATUS_401 = 401;

    /**
     * 非法的系统代码，请检查系统代码是否合法
     */
    public static final int STATUS_402 = 402;

    /**
     * 不存在的应用系统代码
     */
    public static final int STATUS_403 = 403;

    /**
     * 请求的服务的不存在
     */
    public static final int STATUS_404 = 404;

    /**
     * 请求的服务的不可用
     */
    public static final int STATUS_405 = 405;

    /**
     * 请求的服务的已经停止运行
     */
    public static final int STATUS_406 = 406;

    /**
     * 请求的服务已经废弃
     */
    public static final int STATUS_407 = 407;

    /**
     * 不能识别的请求参数的数据类型
     */
    public static final int STATUS_408 = 408;

    /**
     * 服务器内部错误
     */
    public static final int STATUS_500 = 500;

    /**
     * 非法的请求证书，请检查证书是否合法
     */
    public static final int STATUS_501 = 501;

    /**
     * 请求已经超时
     */
    public static final int STATUS_502 = 502;

    /**
     * 异地节点无法连接
     */
    public static final int STATUS_503 = 503;

    /**
     * 请求的IP地址被请求服务平台拒绝访问：
     */
    public static final int STATUS_504 = 504;

    /**
     * 服务提供方的服务出错
     */
    public static final int STATUS_600 = 600;

    /**
     * 服务提供方自定义的异常信息
     */
    public static final int STATUS_601 = 601;

    /**
     * 应用系统的系统代码与授权码不匹配
     */
    public static final int STATUS_602 = 602;

    /**
     * 用户相关，会话无效
     */
    public static final int USER = 80001;

    /**
     * 文件相关
     */
    public static final int FILE = 801;

    static {
        constants.put(STATUS_200, "正常；请求已经完成");
        constants.put(STATUS_202, "正常;已接受用于处理，但处理尚未完成");
        constants.put(STATUS_203, "正常；返回的只是一部分信息");
        constants.put(STATUS_204, "正常；无响应-已接受请求，但不存在要回送的信息。");
        constants.put(STATUS_400, "错误的请求，请求的参数类型与服务方要求的不匹配");
        constants.put(STATUS_401, "请求的服务未经授权");
        constants.put(STATUS_402, "请求缺少必要的参数，请检查（服务代码/版本号/系统代码/授权码）");
        constants.put(STATUS_403, "无法识别的应用系统代码");
        constants.put(STATUS_404, "请求的服务的不存在");
        constants.put(STATUS_405, "请求的服务的不可用");
        constants.put(STATUS_406, "请求的服务的已经停止运行");
        constants.put(STATUS_407, "请求的服务已经废弃");
        constants.put(STATUS_408, "不能识别的请求参数的数据类型");
        constants.put(STATUS_500, "服务器内部错误");
        constants.put(STATUS_501, "非法的请求证书，请检查证书是否合法");
        constants.put(STATUS_502, "请求已经超时");
        constants.put(STATUS_503, "异地节点无法连接");
        constants.put(STATUS_504, "请求的IP地址被拒绝访问");
        constants.put(STATUS_600, "服务提供方的服务出错");
        constants.put(STATUS_601, "服务提供方自定义的异常信息");
        constants.put(STATUS_602, "应用系统的系统代码与授权码不匹配");
        constants.put(USER, "用户会话无效");
        constants.put(FILE, "文件相关");
    }

    public static String valueOf(int code) {
        String message = constants.get(code);
        if (StringUtils.isEmpty(message)) {
            message = "未知错误";
        }
        return message;
    }

    public static boolean isSuccess(int code) {
        return code >= STATUS_200 && code <= STATUS_204;
    }
}
