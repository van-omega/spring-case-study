package com.example.casestudy.util;

import com.example.casestudy.dto.BookTrackDTO;
import com.example.casestudy.entity.BookTrack;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookTrackMapper {
        BookTrackDTO bookTrackToBookTrackDTO(BookTrack bookTrack);
        BookTrack bookTrackDTOtoEntity(BookTrackDTO bookTrackDTO);
}
