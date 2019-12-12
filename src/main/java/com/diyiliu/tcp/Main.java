package com.diyiliu.tcp;

import com.diyiliu.tcp.netty.TcpServer;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 * Description: Main
 * Author: DIYILIU
 * Update: 2019-12-12 17:00
 */
public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println(args);

        Options options = new Options();
        options.addOption("p", "port", true, "端口号");


        CommandLineParser parser = new DefaultParser();
        CommandLine cli = parser.parse( options, args);

        int port = 8848;
        if (cli.hasOption("port")) {
            port = Integer.parseInt(cli.getOptionValue("port"));
        }

        new TcpServer().bind(port);
    }
}
