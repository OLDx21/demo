package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class CryptoClass {
    @Id
    double unix;
    @Field
    int tradecount;
    @Field
    String symbol;
    @Field
    Date date;
    @Field
    double open;
    @Field
    double high;
    @Field
    double low;
    @Field
    double close;
    @Field
    double VolumeADA;
    @Field
    double VolumeUSDT;


    public CryptoClass() {

    }

    public CryptoClass(double unix, Date date, String symbol, double open, double high, double low, double close, double volumeADA, double volumeUSDT, int tradecount) {
        this.unix = unix;
        this.tradecount = tradecount;
        this.date = date;
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.VolumeADA = volumeADA;
        this.VolumeUSDT = volumeUSDT;
    }

    public double getUnix() {
        return unix;
    }

    public void setUnix(double unix) {
        this.unix = unix;
    }

    public int getTradecount() {
        return tradecount;
    }

    public void setTradecount(int tradecount) {
        this.tradecount = tradecount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getVolumeADA() {
        return this.VolumeADA;
    }

    public void setVolumeADA(double volumeADA) {
        this.VolumeADA = volumeADA;
    }

    public double getVolumeUSDT() {
        return this.VolumeUSDT;
    }

    public void setVolumeUSDT(double volumeUSDT) {
        this.VolumeUSDT = volumeUSDT;
    }

    @Override
    public String toString() {
        return "CryptoClass{" +
                "unix=" + unix +
                ", tradecount=" + tradecount +
                ", symbol='" + symbol + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", VolumeADA=" + VolumeADA +
                ", VolumeUSDT=" + VolumeUSDT +
                '}';
    }
}
