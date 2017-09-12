package com.redisinaction.first;

import redis.clients.jedis.Jedis;

/**
 * @author zhailzh
 * 
 * @Date 2016��3��2��������5:23:43
 * 
 */
public class Article {

 private static Jedis jedis = JRedisHolder.getJedis();
 
 public static void main(String[] args){
   System.out.println(jedis.get("aa"));
 }
}
