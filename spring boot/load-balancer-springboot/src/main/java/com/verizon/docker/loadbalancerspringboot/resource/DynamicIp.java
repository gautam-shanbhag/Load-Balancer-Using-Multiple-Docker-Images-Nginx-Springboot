package com.verizon.docker.loadbalancerspringboot.resource;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DynamicIp {

@Value( "${server.port}" )
private String port;

@GetMapping("/gethost")
public String getHost() {
	InetAddress ip;
	  try {

		ip = InetAddress.getLocalHost();
		return "[Current IP address : " + ip.getHostAddress()+":"+port+ "] \t [Current IP Host Name : " + ip.getHostName()+"]";

	  } catch (UnknownHostException e) {

		e.printStackTrace();
		return  "Error";
	  }
}

}

