package com.JobFindingPlatform.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JobFindingPlatform.Entity.Application;
import com.JobFindingPlatform.Enum.JobType;

public interface ApplicationRepository extends JpaRepository<Application,Long>{
	List<Application>findByjobSeekerEmail(String jobSeekerEmail);
	List<Application>findByRecruiterEmail(String recruiterEmail);
	Optional<Application>findByjobSeekerEmailAndJobId(String jobSeekerEmail,Long jobId);
	Optional<Application>findByjobTitle(String jobtitle);
	Optional<Application>findByJobType(JobType jobType);	
}
