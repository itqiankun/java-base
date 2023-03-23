package com.itqiankun.contract;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/3/23
 **/
public class Client {
    public static void main(String[] args) {
        Map<String, Contract> contractMap = new HashMap<>();
        contractMap.put("phone", new PhoneContract());
        contractMap.put("win", new WinContract());

        handlerContract("phone", contractMap);
//        handlerContract("win", contractMap);

    }

    private static void handlerContract(String arg, Map<String, Contract> contractMap) {
        Contract contract = contractMap.get(arg);
        contract.handler();
    }
}
