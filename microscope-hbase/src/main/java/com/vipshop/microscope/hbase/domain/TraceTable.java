package com.vipshop.microscope.hbase.domain;

import java.io.Serializable;
import java.util.List;


public class TraceTable implements Serializable, Comparable<TraceTable> {
	
	private static final long serialVersionUID = -2609783475042433846L;
	
	private String type;
	private String traceId;
	private String traceName;
	private String startTimestamp;
	private String endTimestamp;
	private String duration;
	
	public String getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(String startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public String getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(String endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public TraceTable(String traceName) {
		this.traceName = traceName;
	}
	
	public TraceTable(String traceId, String traceName) {
		this.traceId = traceId;
		this.traceName = traceName;
	}
	
	public TraceTable(String traceId, String traceName, String startTimestamp, String endTimestamp, String duration) {
		super();
		this.traceId = traceId;
		this.traceName = traceName;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.duration = duration;
	}
	
	public TraceTable(String type, String traceId, String traceName, String startTimestamp, String endTimestamp, String duration) {
		super();
		this.type = type;
		this.traceId = traceId;
		this.traceName = traceName;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.duration = duration;
	}

	public String getTraceId() {
		return traceId;
	}
	
	public String getTraceName() {
		return traceName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TraceTable [type=" + type + ", traceId=" + traceId + ", traceName=" + traceName + ", startTimestamp=" + startTimestamp + ", endTimestamp=" + endTimestamp + ", duration=" + duration
				+ "]";
	}

	@Override
	public int compareTo(TraceTable o) {
		if (Long.valueOf(this.getDuration()) > Long.valueOf(o.getDuration())) {
			return 1;
		}
		
		if (Long.valueOf(this.getDuration()) < Long.valueOf(o.getDuration())) {
			return -1;
		}
		
		return 0;
	}
	
	public static float avgDuration(List<TraceTable> tableTraces) {
		long sum = 0;
		for (TraceTable traceTable : tableTraces) {
			sum += Long.valueOf(traceTable.getDuration());
		}
		return sum / tableTraces.size() / 1000;
	}
	
}
