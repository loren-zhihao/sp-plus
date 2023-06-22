// 定义菜单列表
var menuList =	[
	{
		name: 'sp-admin',
		path: '/sp-admin',
		component: Layout,
        meta: {
          title: '系统管理员表',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: 'sp-admin-list',
                path: 'sp-admin-list',
                component: () => import('@/sp-views/sp-admin/sp-admin-list.vue'),
                meta: { title: '系统管理员表-列表' }
            },
            {
                name: 'sp-admin-add',
                path: 'sp-admin-add',
                component: () => import('@/sp-views/sp-admin/sp-admin-add.vue'),
                meta: { title: '系统管理员表-新增' }
            },
            {
                name: 'sp-admin-info',
                path: 'sp-admin-info',
                component: () => import('@/sp-views/sp-admin/sp-admin-info.vue'),
                meta: { title: '系统管理员表-详情' }
            },
		]
	},
	{
		name: 'sp-vedio',
		path: '/sp-vedio',
		component: Layout,
        meta: {
          title: '视频表',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: 'sp-vedio-list',
                path: 'sp-vedio-list',
                component: () => import('@/sp-views/sp-vedio/sp-vedio-list.vue'),
                meta: { title: '视频表-列表' }
            },
            {
                name: 'sp-vedio-add',
                path: 'sp-vedio-add',
                component: () => import('@/sp-views/sp-vedio/sp-vedio-add.vue'),
                meta: { title: '视频表-新增' }
            },
            {
                name: 'sp-vedio-info',
                path: 'sp-vedio-info',
                component: () => import('@/sp-views/sp-vedio/sp-vedio-info.vue'),
                meta: { title: '视频表-详情' }
            },
		]
	},
]