package com.machine.dragon.web.system.dictionary.fade;

import com.machine.dragon.web.system.dictionary.controller.request.DragonEnumResponse;

import java.util.List;

public interface DragonEnumFade {
    List<DragonEnumResponse> queryEnumList(String enumName);
}
