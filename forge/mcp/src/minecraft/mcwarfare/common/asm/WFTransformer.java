package mcwarfare.common.asm;

import cpw.mods.fml.relauncher.IClassTransformer;

public class WFTransformer implements IClassTransformer {

	@Override
	public byte[] transform(String name, byte[] bytes) {
		return bytes;
	}

}
