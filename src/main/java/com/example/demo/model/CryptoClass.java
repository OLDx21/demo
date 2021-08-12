package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
public class CryptoClass {
    @Id
    double unix;

    int tradecount;
    String symbol;
    Date date;
    double open,high,low,close,VolumeADA,VolumeUSDT;

    public CryptoClass(double unix,Date date,  String symbol, double open, double high, double low, double close, double volumeADA, double volumeUSDT, int tradecount) {
        this.unix = unix;
        this.tradecount = tradecount;
        this.date = date;
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        VolumeADA = volumeADA;
        VolumeUSDT = volumeUSDT;
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
        return VolumeADA;
    }

    public void setVolumeADA(double volumeADA) {
        VolumeADA = volumeADA;
    }

    public double getVolumeUSDT() {
        return VolumeUSDT;
    }

    public void setVolumeUSDT(double volumeUSDT) {
        VolumeUSDT = volumeUSDT;
    }

}
