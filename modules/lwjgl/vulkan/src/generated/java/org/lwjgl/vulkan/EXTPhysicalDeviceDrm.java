/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

/**
 * This extension provides new facilities to query DRM properties for physical devices, enabling users to match Vulkan physical devices with DRM nodes on Linux.
 * 
 * <p>Its functionality closely overlaps with {@code EGL_EXT_device_drm}<sup><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.2-extensions/html/vkspec.html#VK_EXT_physical_device_drm-fn1">1</a></sup>. Unlike the EGL extension, this extension does not expose a string containing the name of the device file and instead exposes device minor numbers.</p>
 * 
 * <p>DRM defines multiple device node types. Each physical device may have one primary node and one render node associated. Physical devices may have no primary node (e.g. if the device does not have a display subsystem), may have no render node (e.g. if it is a software rendering engine), or may have neither (e.g. if it is a software rendering engine without a display subsystem).</p>
 * 
 * <p>To query DRM properties for a physical device, chain {@link VkPhysicalDeviceDrmPropertiesEXT} to {@link VkPhysicalDeviceProperties2}.</p>
 * 
 * <h5>References</h5>
 * 
 * <ul>
 * <li><a target="_blank" href="https://www.khronos.org/registry/EGL/extensions/EXT/EGL_EXT_device_drm.txt">{@code EGL_EXT_device_drm}</a></li>
 * </ul>
 * 
 * <h5>VK_EXT_physical_device_drm</h5>
 * 
 * <dl>
 * <dt><b>Name String</b></dt>
 * <dd>{@code VK_EXT_physical_device_drm}</dd>
 * <dt><b>Extension Type</b></dt>
 * <dd>Device extension</dd>
 * <dt><b>Registered Extension Number</b></dt>
 * <dd>354</dd>
 * <dt><b>Revision</b></dt>
 * <dd>1</dd>
 * <dt><b>Extension and Version Dependencies</b></dt>
 * <dd><ul>
 * <li>Requires Vulkan 1.0</li>
 * <li>Requires {@link KHRGetPhysicalDeviceProperties2 VK_KHR_get_physical_device_properties2}</li>
 * </ul></dd>
 * <dt><b>Contact</b></dt>
 * <dd><ul>
 * <li>Simon Ser <a target="_blank" href="https://github.com/KhronosGroup/Vulkan-Docs/issues/new?title=VK_EXT_physical_device_drm:%20&amp;body=@emersion%20">emersion</a></li>
 * </ul></dd>
 * </dl>
 * 
 * <h5>Other Extension Metadata</h5>
 * 
 * <dl>
 * <dt><b>Last Modified Date</b></dt>
 * <dd>2021-06-09</dd>
 * <dt><b>IP Status</b></dt>
 * <dd>No known IP claims.</dd>
 * <dt><b>Contributors</b></dt>
 * <dd><ul>
 * <li>Simon Ser</li>
 * </ul></dd>
 * </dl>
 */
public final class EXTPhysicalDeviceDrm {

    /** The extension specification version. */
    public static final int VK_EXT_PHYSICAL_DEVICE_DRM_SPEC_VERSION = 1;

    /** The extension name. */
    public static final String VK_EXT_PHYSICAL_DEVICE_DRM_EXTENSION_NAME = "VK_EXT_physical_device_drm";

    /** Extends {@code VkStructureType}. */
    public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DRM_PROPERTIES_EXT = 1000353000;

    private EXTPhysicalDeviceDrm() {}

}