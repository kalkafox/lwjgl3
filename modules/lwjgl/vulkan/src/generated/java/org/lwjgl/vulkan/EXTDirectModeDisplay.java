/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

/**
 * This is extension, along with related platform extensions, allows applications to take exclusive control of displays associated with a native windowing system. This is especially useful for virtual reality applications that wish to hide HMDs (head mounted displays) from the native platform’s display management system, desktop, and/or other applications.
 * 
 * <h5>VK_EXT_direct_mode_display</h5>
 * 
 * <dl>
 * <dt><b>Name String</b></dt>
 * <dd>{@code VK_EXT_direct_mode_display}</dd>
 * <dt><b>Extension Type</b></dt>
 * <dd>Instance extension</dd>
 * <dt><b>Registered Extension Number</b></dt>
 * <dd>89</dd>
 * <dt><b>Revision</b></dt>
 * <dd>1</dd>
 * <dt><b>Extension and Version Dependencies</b></dt>
 * <dd><ul>
 * <li>Requires Vulkan 1.0</li>
 * <li>Requires {@link KHRDisplay VK_KHR_display}</li>
 * </ul></dd>
 * <dt><b>Contact</b></dt>
 * <dd><ul>
 * <li>James Jones <a target="_blank" href="https://github.com/KhronosGroup/Vulkan-Docs/issues/new?title=VK_EXT_direct_mode_display:%20&amp;body=@cubanismo%20">cubanismo</a></li>
 * </ul></dd>
 * </dl>
 * 
 * <h5>Other Extension Metadata</h5>
 * 
 * <dl>
 * <dt><b>Last Modified Date</b></dt>
 * <dd>2016-12-13</dd>
 * <dt><b>IP Status</b></dt>
 * <dd>No known IP claims.</dd>
 * <dt><b>Contributors</b></dt>
 * <dd><ul>
 * <li>Pierre Boudier, NVIDIA</li>
 * <li>James Jones, NVIDIA</li>
 * <li>Damien Leone, NVIDIA</li>
 * <li>Pierre-Loup Griffais, Valve</li>
 * <li>Liam Middlebrook, NVIDIA</li>
 * </ul></dd>
 * </dl>
 */
public class EXTDirectModeDisplay {

    /** The extension specification version. */
    public static final int VK_EXT_DIRECT_MODE_DISPLAY_SPEC_VERSION = 1;

    /** The extension name. */
    public static final String VK_EXT_DIRECT_MODE_DISPLAY_EXTENSION_NAME = "VK_EXT_direct_mode_display";

    protected EXTDirectModeDisplay() {
        throw new UnsupportedOperationException();
    }

    // --- [ vkReleaseDisplayEXT ] ---

    /**
     * Release access to an acquired VkDisplayKHR.
     * 
     * <h5>C Specification</h5>
     * 
     * <p>To release a previously acquired display, call:</p>
     * 
     * <pre><code>
     * VkResult vkReleaseDisplayEXT(
     *     VkPhysicalDevice                            physicalDevice,
     *     VkDisplayKHR                                display);</code></pre>
     * 
     * <h5>Valid Usage (Implicit)</h5>
     * 
     * <ul>
     * <li>{@code physicalDevice} <b>must</b> be a valid {@code VkPhysicalDevice} handle</li>
     * <li>{@code display} <b>must</b> be a valid {@code VkDisplayKHR} handle</li>
     * <li>{@code display} <b>must</b> have been created, allocated, or retrieved from {@code physicalDevice}</li>
     * </ul>
     * 
     * <h5>Return Codes</h5>
     * 
     * <dl>
     * <dt>On success, this command returns</dt>
     * <dd><ul>
     * <li>{@link VK10#VK_SUCCESS SUCCESS}</li>
     * </ul></dd>
     * </dl>
     *
     * @param physicalDevice The physical device the display is on.
     * @param display        The display to release control of.
     */
    @NativeType("VkResult")
    public static int vkReleaseDisplayEXT(VkPhysicalDevice physicalDevice, @NativeType("VkDisplayKHR") long display) {
        long __functionAddress = physicalDevice.getCapabilities().vkReleaseDisplayEXT;
        if (CHECKS) {
            check(__functionAddress);
        }
        return callPJI(physicalDevice.address(), display, __functionAddress);
    }

}