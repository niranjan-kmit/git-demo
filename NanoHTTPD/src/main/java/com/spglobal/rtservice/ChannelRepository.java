package com.spglobal.rtservice;

import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<Channel, String>{
	Channel findByChannel(String channel);
}
