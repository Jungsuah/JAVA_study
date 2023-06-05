package kr.ac.kopo.ctc.kopo27.domain;

public class VotingResult {
	private int id;
	private int ageGroup;
	private String name;
	private int voteCount;
	private double votePercentage;

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public double getVotePercentage() {
		return votePercentage;
	}

	public void setVotePercentage(double votePercentage) {
		this.votePercentage = votePercentage;
	}
}
