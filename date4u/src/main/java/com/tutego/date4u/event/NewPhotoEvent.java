package com.tutego.date4u.event;

import java.time.OffsetDateTime;

import org.springframework.core.style.ToStringCreator;

public record NewPhotoEvent (String name, OffsetDateTime offsetDateTime) {
}
