package com.jobsequencingTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job {
	int id;
	int deadline;
	int profit;

	public Job(int id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class JobSequencingSolution {

	public List<Job> jobSequencing(List<Job> jobs) {
		Collections.sort(jobs, (j1, j2) -> j2.profit - j1.profit);

		int maxDeadline = 0;
		for (Job job : jobs) {
			if (job.deadline > maxDeadline) {
				maxDeadline = job.deadline;
			}
		}

		int[] slots = new int[maxDeadline + 1];

		List<Job> result = new ArrayList<>();
		for (Job job : jobs) {
			for (int i = job.deadline; i > 0; i--) {
				if (slots[i] == 0) {
					slots[i] = job.id;
					result.add(job);
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 4, 20));
		jobs.add(new Job(2, 1, 10));
		jobs.add(new Job(3, 1, 40));
		jobs.add(new Job(4, 1, 30));

		JobSequencingSolution solution = new JobSequencingSolution();
		List<Job> sequence = solution.jobSequencing(jobs);

		System.out.println("Sequence of jobs for maximum profit:");
		for (Job job : sequence) {
			System.out.println("Job Id: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
		}
	}
}
